<#import "../layout.ftl" as layoutTemplate>
<@layoutTemplate.layout>

<div class="container panel-box">
<h1>${diaryEntry.title}</h1>
​
    <div class="form-group">
        <h1 name="title" id="title" class="form-control">${diaryEntry.title}</h1>
    </div>
    ​
    <div class="form-group">
        <label for="category">Category</label>
        <p name="category" id="category" class="form-control">${diaryEntry.sessionType}</p>
    </div>
    ​
    <div class="form-group">
        <label for="date">Date</label>
        <p name="date" id="date" class="form-control">${diaryEntry.startDate}</p>
    </div>

    <div class="form-group">
        <label for="startTime">Start time</label>
        <p name="startTime" id="startTime" class="form-control">${diaryEntry.startTime}</p>
    </div>

    <div class="form-group">
      <label for="sessionGoal">Session goal</label>
       <p name="sessionGoal" id="sessionGoal" class="form-control">${diaryEntry.sessionGoal}</p>
    </div>   ​
</div>


</@layoutTemplate.layout>
