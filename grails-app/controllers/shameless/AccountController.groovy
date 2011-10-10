package shameless

class AccountController {

    //static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [accountInstanceList: Account.list(params), accountInstanceTotal: Account.count()]
    }

    def create = {
        def accountInstance = new Account()
        accountInstance.properties = params
        return [accountInstance: accountInstance]
    }

    def save = {
        def accountInstance = new Account(params)
        if (accountInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'account.label', default: 'Account'), accountInstance.id])}"
            redirect(action: "show", id: accountInstance.id)
        }
        else {
            render(view: "create", model: [accountInstance: accountInstance])
        }
    }

    def show = {
        def accountInstance = Account.get(params.id)
        if (!accountInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])}"
            redirect(action: "list")
        }
        else {
            [accountInstance: accountInstance]
        }
    }

    def edit = {
        def accountInstance = Account.get(params.id)
        if (!accountInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [accountInstance: accountInstance]
        }
    }

    def update = {
        def accountInstance = Account.get(params.id)
        if (accountInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (accountInstance.version > version) {
                    
                    accountInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'account.label', default: 'Account')] as Object[], "Another user has updated this Account while you were editing")
                    render(view: "edit", model: [accountInstance: accountInstance])
                    return
                }
            }
            accountInstance.properties = params
            if (!accountInstance.hasErrors() && accountInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'account.label', default: 'Account'), accountInstance.id])}"
                redirect(action: "show", id: accountInstance.id)
            }
            else {
                render(view: "edit", model: [accountInstance: accountInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def accountInstance = Account.get(params.id)
        if (accountInstance) {
            try {
                accountInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'account.label', default: 'Account'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'account.label', default: 'Account'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])}"
            redirect(action: "list")
        }
    }
}
