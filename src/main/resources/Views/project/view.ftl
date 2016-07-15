<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

 <div class="panel-box projHead">
      <h1>${project.name}</h1>

      <hr>

      <h2>Description</h2>
      <p>${project.description}</p>
  </div>

      <div class="row">

        <a href="/project/${project.id}/diary">

          <div class="col-sm-6 diaryBlock">

            <div class="panel-box dashBtn clearfix">

              <div class="pull-left">

                <i class="fa fa-book"></i>

              </div>

              <div class="pull-left text">

                Diary entries

              </div>

            </div>

          </div>

        </a>

      </div>

</@layoutTemplate.layout>
