<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

    <#list contacts as contact>
      <@contact fullName="${contact.fullName}" jobTitle="${contact.jobTitle}" company="${contact.company}" email="${contact.email}" number="${contact.number}" mobile=${contact.mobile} />
    </#list>

</@layoutTemplate.layout>

<ul>
<li>
<#macro contact fullName jobTitle company email number mobile>
  <div class="contact">


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
</li>
<ul>
