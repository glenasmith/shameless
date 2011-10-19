<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Upload</title>
    <meta name="layout" content="seefoodapp"/>
    <r:require module="jqueryValidate"/>

    <bean:labelTemplate> <label for="${fieldId}" class="${errorClassToUse}">${label}${required}</label> </bean:labelTemplate>
    <bean:inputTemplate> <div class="clearfix"> ${label} <div class="input">${field}</div> <g:if test="${errors}"><br/>${errors}</g:if> </div></bean:inputTemplate>
    <bean:textAreaTemplate> <div class="clearfix"> ${label} <div class="input">${field}</div> <g:if test="${errors}"><br/>${errors}</g:if> </div></bean:textAreaTemplate>
    <bean:checkBoxTemplate> <div class="clearfix"> ${label} <div class="input">${field}</div> <g:if test="${errors}"><br/>${errors}</g:if> </div></bean:checkBoxTemplate>

    <style>
        label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
    </style>
    <%--
    Other useful templates include
    <bean:requiredIndicator> <img src="/images/required-field.png" alt="(!)"> </bean:requiredIndicator>
    <bean:errorTemplate> <div class="fieldError">Ooops! ${message.encodeAsHTML()}</div> </bean:errorTemplate>
    --%>


  </head>

  <body>

  <div class="page-header">
          <h1><sec:username/>, Let's Upload a Meal</h1>
        </div>

        <g:if test="${flash.error}">
          <div class="alert-message error">
              <p><strong>Snap!</strong> ${flash.error}. <g:renderErrors bean="mealInstance"/> </p>
          </div>
        </g:if>
        <g:elseif test="${flash.message}">
          <div class="alert-message success">
              <p><strong>Win!</strong> ${flash.message}.</p>
          </div>
        </g:elseif>

        <div class="row">
          <div class="span15">
            <h2>What are you eating?</h2>
            <g:uploadForm class="uploadForm" action="save" >
              <fieldset>

              <bean:withBean beanName="mealInstance">
                  <bean:field property="status" label="Why bro?" class="required"/>
                  <bean:field property="longitude" class="number"/>
                  <bean:field property="latitude" class="number"/>
                  <bean:checkBox property="badFood"/>
                   <bean:label property="pictures"/>
                  <div class="input">
                        <input type="file" name="picture" class="required" />
                  </div>
              </bean:withBean>


              <g:submitButton name="uploadButton" value="Upload" class="btn primary"/>
              </fieldset>

            </g:uploadForm>

          </div>

        </div>

  <r:script>
      $(document).ready(function(){
            $(".uploadForm").validate();
      });
  </r:script>



  </body>

</html>
