<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

    <#list entries as entry>
      <@diaryEntry title="${entry.title}" sessionType="${entry.sessionType}" date="${entry.startDate}" time="${entry.startTime}" goal="${entry.sessionGoal}" />
    </#list>

</@layoutTemplate.layout>

<#macro diaryEntry title sessionType date time goal>
  <div class="diary">

    <div class="content">
      <h3 class="title">${title}</h3><br/>
      <p class="subtitle">${sessionType}</p><br/>
      <p>Date <span>${date}</span></p><br/>
      <p>at <span>${time}</span></p><br/>
      <p>${goal}</p><br/>
    </div>

  </div>
</#macro>
