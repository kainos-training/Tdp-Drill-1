<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>



    <#list contacts as contact>

    <div class="well">
      <h3 class="title">${contact.name}</h3>
      <p class="subtitle">${contact.jobTitle}</p>
      <pre>Company: <span>${contact.company}</span> <br>Email: <span>${contact.email}</span>      Landline: ${contact.number}     Mobile: ${contact.mobile}</pre>
    </div>
    <br>
    </#list>




</@layoutTemplate.layout>



