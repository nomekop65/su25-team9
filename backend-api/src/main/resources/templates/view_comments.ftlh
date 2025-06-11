<!DOCTYPE html>
<html>
<head>
    <title>View Comments</title>
    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Comments for ${customer.username}</h2>
    <ul class="list-group">
        <#list reviews as review>
            <li class="list-group-item">${review.comment}</li>
        </#list>
    </ul>
    <a href="/customers" class="btn btn-secondary mt-3">Back to Customers</a>
</div>
</body>
</html>