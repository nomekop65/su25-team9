<!DOCTYPE html>
<html>
<head>
    <title>Add Comment</title>
    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Add Comment</h2>
    <form action="/comments/add" method="post">
        <input type="hidden" name="customerId" value="${customerId}"/>
        <input type="hidden" name="providerId" value="1"/>
        <div class="mb-3">
            <label for="comment" class="form-label">Comment</label>
            <textarea class="form-control" id="comment" name="comment" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit Comment</button>
    </form>
</div>
</body>
</html>