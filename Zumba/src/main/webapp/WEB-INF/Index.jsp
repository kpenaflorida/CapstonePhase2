<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gym Management Solution</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h3 class="card-title">Welcome to Zumba Gym Management Solution</h3>
                <!-- Using JSP Expressions to dynamically include links -->
                <a href="<%= request.getContextPath() %>/add-batch.jsp" class="btn btn-primary mt-2">Add Batch</a>
                <br />
                <a href="<%= request.getContextPath() %>/add-participant.jsp" class="btn btn-primary mt-2">Add Participant</a>
                <br />
                <a href="<%= request.getContextPath() %>/update-batch.jsp" class="btn btn-primary mt-2">Update Batch</a>
                <br />
                <a href="<%= request.getContextPath() %>/update-participant.jsp" class="btn btn-primary mt-2">Update Participant</a>
                <br />
            </div>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-CSw2k5Ri0lKXz7jGOTfpCf1SkO/5DLE9IR84LwFfYER4LIS2gq3Y6PrH61XA9wOW" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>