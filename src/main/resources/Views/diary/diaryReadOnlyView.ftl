<#import "../layout.ftl" as layoutTemplate>
<@layoutTemplate.layout>

<div class="container panel-box">
<h1>${diaryEntry.title}</h1>
    ​
    <div class="form-group">
        <label for="category">Category</label>
        <p name="category" id="category">${diaryEntry.sessionType}</p>
    </div>
    ​
    <div class="form-group">
        <label for="date">Date</label>
        <p name="date" id="date">${diaryEntry.startDate}</p>
    </div>

    <br/>

    <div class="form-group">
        <label for="startTime">Start time</label>
        <p name="startTime" id="startTime">${diaryEntry.startTime}</p>
    </div>

    <br/>

    <div class="form-group">
      <label for="sessionGoal">Session goal</label>
       <p name="sessionGoal" id="sessionGoal">${diaryEntry.sessionGoal}</p>
    </div>

     <br​/>

     <div class="form-group">
           <label for="image">Image URL</label>
            <p name="image" id="image">${diaryEntry.imageUrl}</p>
         </div>

</div>


</@layoutTemplate.layout>
