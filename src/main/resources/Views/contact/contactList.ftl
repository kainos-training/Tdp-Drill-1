<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>



    <#list contacts as contact>



          <div class="diary">

            <div class="content">
              <h3 class="title">${contact.name}</h3>
              <p class="subtitle">${contact.company}</p>
              <p><span>Job Title </span>${contact.jobTitle}</p>
              <p><span>Email </span>${contact.email}</p>
              <p><span>Number </span>${contact.number}</p>
              <p class="goal"><span>Mobile </span>${contact.mobile}</p>
            </div>

          </div>
    <br>
    </#list>




</@layoutTemplate.layout>



