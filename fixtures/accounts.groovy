import shameless.*

fixture {

    adminRole(Role, authority: 'ROLE_ADMIN')
    userRole(Role, authority: 'ROLE_USER')

    adminUser(Account, username: 'admin', enabled: true, password: 'admin123', realName: 'Admin User', email: 'admin@admin.com')

    accountRole(AccountRole, account: adminUser, role: adminRole)

}
