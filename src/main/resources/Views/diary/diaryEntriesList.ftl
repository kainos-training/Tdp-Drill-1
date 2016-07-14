<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

    <#list entries as entry>
      <@diaryEntry entry="entry"/>
    </#list>

</@layoutTemplate.layout>

<#macro diaryEntry entry>
  <div>

    ${entry.title}
    ${entry.sessionType}
    Date: ${entry.startDate}
    Start Time: ${entry.startTime}
    ${entry.sessionGoal}

  </div>
</#macro>
