<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>




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
