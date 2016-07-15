<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>
    <div class="row">
        <div class="col-md-8">
            <h2 class="pageTitle">Diary entries</h2>
        </div>
        <div class="col-md-4 diary_bottom">
            <form>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Enter tag">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Search</button>
                    </span>
                </div>
            </form>
        </div>
    </div>

    <#list entries as entry>
      <@diaryEntry
        title="${entry.title}"
        sessionType="${entry.sessionType}"
        date="${entry.startDate}"
        time="${entry.startTime}"
        goal="${entry.sessionGoal}" />
    </#list>

    <a href="/project/${project.id}/diary/add" class="btn btn-primary">Add diary entry</a>

</@layoutTemplate.layout>

<#macro diaryEntry title sessionType date time goal>
  <div class="diary">

    <div class="content">
      <h3 class="title">${title}</h3>
      <p class="subtitle">${sessionType}</p>
      <p><span>Date </span>${date}</p>
      <p><span>Start time </span>${time}</p>
      <p class="goal"><span>Session goal</span> <br/>${goal}</p>
    </div>

  </div>
</#macro>
