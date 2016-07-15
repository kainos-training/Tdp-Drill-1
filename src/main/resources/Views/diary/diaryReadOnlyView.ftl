<#import "../layout.ftl" as layoutTemplate>
<@layoutTemplate.layout>

<div class="container panel-box">
<h1>${project.title}</h1>
​
    <div class="form-group">
        <h1 name="title" id="title" class="form-control">${project.title}</h1>
    </div>
    ​
    <div class="form-group">
        <label for="category">Category</label>
        <p name="category" id="category" class="form-control">${project.category}</p>
    </div>
    ​
    <div class="form-group">
        <label for="date">Date</label>
        <p name="date" id="date" class="form-control">${project.date}</p>
    </div>

    <div class="form-group">
        <label for="startTime">Start time</label>
        <p name="startTime" id="startTime" class="form-control">${project.startTime}</p>
    </div>
        ​
    <div class="form-group">
        <label for="endTime">End time</label>
        <p name="date" id="date" class="form-control">${project.endTime}</p>
    </div>

    <div class="form-group">
      <label for="sessionGoal">Session goal</label>
       <p name="sessionGoal" id="sessionGoal" class="form-control">${project.sessionGoal}</p>
    </div>   ​
</div>


</@layoutTemplate.layout>
