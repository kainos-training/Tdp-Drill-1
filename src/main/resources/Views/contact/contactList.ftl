<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

  <div class="contact">


    <#list contacts as contact>

    <div class="content panel-box">
      <h3 class="title">${contact.name}</h3>
      <p class="subtitle">${contact.jobTitle}</p>
      <p>Company: <span>${contact.company}</span></p>
      <p>Email: <span>${contact.email}</span></p>
      <p>Landline: ${contact.number}</p>
      <p>Mobile: ${contact.mobile}</p>
    </div>
    </#list>
  </div>



</@layoutTemplate.layout>



