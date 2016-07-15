<#import "../layout.ftl" as layoutTemplate>
<@layoutTemplate.layout>

<div class="container panel-box">
<h1>Add new diary entry</h1>
<p class="lead">Please ensure accurate information is provided below before attempting to add this new diary entry.</p>
​
<form enctype="multipart/form-data" id="myForm" class="form-horizontal" autocomplete="off" data-toggle="validator" method="post" action="/project/${project.id}/diary/add">

   <div class="form-group">
        <label for="title">Title</label>
        <input name="title" id="title" type="text" placeholder="Title" class="form-control" data-error="Enter title" required />
        <div class="help-block with-errors"></div>
   </div>
    ​
    <div class="form-group">
        <label for="category">Category</label> <br/>
        <select id="category" name="category" class="form-control" data-error="Select category" required>
            <option class="form-control" value="" disabled selected>Select category</option>
            <option class="form-control" value="VISION">VISION</option>
            <option class="form-control" value="GOALS">GOALS</option>
            <option class="form-control" value="USER_STORY_CREATION">USER STORY CREATION</option>
            <option class="form-control" value="NFRs">NFRs</option>
            <option class="form-control" value="OTHER">OTHER</option>
        </select>
        <div class="help-block with-errors"></div>
    </div>
    ​
    <div class="form-group">
        <label for="date">Date</label>
        <input name="date" id="date" type="text" placeholder="dd/mm/yyyy" data-error="Enter date" class="form-control" required />
        <div class="help-block with-errors"></div>
    </div>
    ​
    ​
    <div class="form-group">
        <label for="startTime">Start time</label>
        <input name="startTime" id="startTime" type="text" placeholder="08:00 - 24hr clock" data-error="Enter start time" class="form-control" required />
        <div class="help-block with-errors"></div>
    </div>
    ​
    <div class="form-group">
        <label for="endTime">End time</label>
        <input name="endTime" id="endTime" type="text" placeholder="08:00 - 24hr clock" data-error="Enter end time" class="form-control" required />
        <div class="help-block with-errors"></div>
    </div>
    ​
    <div class="form-group">
        <label for="sessionGoal">Session goal</label>
        <textarea name="sessionGoal" id="sessionGoal" data-role="none" data-error="Enter session goal" placeholder="Enter text here..." class="form-control sessionGoalTextArea" required></textarea>
        <div class="help-block with-errors"></div>
    </div>
    ​
    ​
    <input type="submit" value="Save diary entry" class="btn btn-primary" />
    ​
</form>
</div>

    <script src="/assets/js/jquery-3.1.0.min.js"></script>
    <script src="/assets/js/validator.js"</script>

    <script>
        $("#myForm").validator();
    </script>

</@layoutTemplate.layout>
