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
        <input name="date" id="date" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}" type="text" placeholder="dd/mm/yyyy" data-error="Enter date in format dd/mm/yyyy" class="form-control" required />
        <div class="help-block with-errors"></div>
    </div>
    ​
    ​
    <div class="form-group">
        <label for="startTime">Start time</label>
        <input name="startTime" id="startTime" pattern="^(2[0-3]|[01]?[0-9]){2}:([0-5]?[0-9]){2}$" type="text" placeholder="08:00 - 24hr clock" data-error="Enter start time in format hh/mm" class="form-control" required />
        <div class="help-block with-errors"></div>
    </div>
    ​
    <div class="form-group">
        <label for="endTime">End time</label>
        <input name="endTime" id="endTime" pattern="^(2[0-3]|[01]?[0-9]){2}:([0-5]?[0-9]){2}$" type="text" placeholder="08:00 - 24hr clock" data-error="Enter end time in format hh/mm" class="form-control" required />
        <div class="help-block with-errors"></div>
    </div>
    ​
    <div class="form-group">
        <label for="sessionGoal">Session goal</label>
        <textarea name="sessionGoal" id="sessionGoal" data-role="none" data-error="Enter session goal" placeholder="Enter text here..." class="form-control sessionGoalTextArea" required></textarea>
        <div class="help-block with-errors"></div>
    </div>

    <div class="form-group">
            <label for="sessionGoal">Image</label>
            <textarea name="imageUrl" id="imageUrl" data-role="none" placeholder="Enter image url..." class="form-control sessionGoalTextArea"></textarea>
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
