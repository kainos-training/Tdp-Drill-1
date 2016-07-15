<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

    <#list people as person>
      <@person fullName="${person.fullName}" jobTitle="${person.jobTitle}" company="${person.company}" email="${person.email}" number="${person.number}" mobile=${person.mobile} />
    </#list>

</@layoutTemplate.layout>

<#macro person fullName jobTitle company email number mobile>
  <div class="person">

    <div class="content">
      <h3 class="title">${fullName}</h3>
      <p class="subtitle">${jobTitle}</p>
      <p>Company: <span>${company}</span></p>
      <p>Email: <span>${email}</span></p>
      <p>Landline: ${number}</p>
      <p>Mobile: ${mobile}</p>
    </div>

  </div>
</#macro>