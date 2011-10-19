<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Upload</title>
    <meta name="layout" content="main"/>

  </head>

  <body>

  <div class="page-header">
          <h1><sec:username/>, Let's Upload a Meal</h1>
        </div>

        <div class="row">
          <div class="span15">
            <h2>What are you eating?</h2>
            <g:uploadForm class="uploadForm" action="save" >
              <fieldset>

                  <div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'status', 'error')} required">
                      <label for="status">
                          <g:message code="meal.status.label" default="Status"/>
                          <span class="required-indicator">*</span>
                      </label>
                      <g:textField name="status" required="" value="${mealInstance?.status}"/>
                  </div>

                  <div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'longitude', 'error')} required">
                      <label for="longitude">
                          <g:message code="longitude.status.label" default="Longitude"/>
                      </label>
                      <g:textField name="longitude" required="" value="${mealInstance?.longitude}"/>
                  </div>

                  <div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'latitude', 'error')} required">
                      <label for="latitude">
                          <g:message code="latitude.status.label" default="Longitude"/>
                      </label>
                      <g:textField name="latitude" required="" value="${mealInstance?.latitude}"/>
                  </div>

                  <div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'badFood', 'error')} ">
                      <label for="badFood">
                          <g:message code="meal.badFood.label" default="Bad Food"/>

                      </label>
                      <g:checkBox name="badFood" value="${mealInstance?.badFood}"/>
                  </div>

                  <div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'pictures', 'error')} ">
                      <label for="pictures">
                          <g:message code="meal.pictures.label" default="Picture"/>
                      </label>
                      <input type="file" name="picture"  />
                  </div>



              </fieldset>

              <g:submitButton name="uploadButton" value="Upload" class="btn primary large"/>



            </g:uploadForm>

          </div>

        </div>


  </body>

</html>
