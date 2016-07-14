<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

    <#list entries as entry>
      <@diaryEntry title="${entry.title}" sessionType="${entry.sessionType}" date="${entry.startDate}" time="${entry.startTime}" goal="${entry.sessionGoal}" />
    </#list>

</@layoutTemplate.layout>

<#macro diaryEntry title sessionType date time goal>
  <div class="panel-box">

    ${title}<br/>
    ${sessionType}<br/>
    Date ${date}<br/>
    at ${time}<br/>
    ${goal}<br/>

  </div>
</#macro>
