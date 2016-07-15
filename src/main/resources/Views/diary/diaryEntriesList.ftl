<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

    <h2 class="pageTitle">Diary entries</h2>
    <#if entries?has_content>
    <#list entries as entry>
      <@diaryEntry
        id = "${entry.diaryId}"
        title="${entry.title}"
        sessionType="${entry.sessionType}"
        date="${entry.startDate}"
        time="${entry.startTime}"
        goal="${entry.sessionGoal}" />
    </#list>
    </#if>

    <#if !entries?has_content>
    <div class="diary">
      <div class="content">
        <h3 class="title nocontent">No diary entries have been added.</h3>
      </div>
    </div>
    </#if>
    <a href="/project/${project.id}/diary/add" class="btn btn-primary">Add diary entry</a>

</@layoutTemplate.layout>

<#macro diaryEntry id title sessionType date time goal>
 <a href="/project/${project.id}/diary/${id}"><div class="diary">

    <div class="content">
      <h3 class="title">${title}</h3>
      <p class="subtitle">${sessionType}</p>
      <p><span>Date </span>${date}</p>
      <p><span>Start time </span>${time}</p>
      <p class="goal"><span>Session goal</span> <br/>${goal}</p>
    </div>

  </div>
  </a>
</#macro>
