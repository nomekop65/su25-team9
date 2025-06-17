<!DOCTYPE html>
<html>
<head>
    <title>Reply to Review</title>
    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2>Reply to Review</h2>
    <p><strong>Review Comment:</strong> ${review.comment}</p>

    <form method="post" action="/reports/reply">
        <input type="hidden" name="reviewId" value="${review.id}" />
        <div class="mb-3">
            <label for="reply">Your Reply:</label>
            <textarea name="reply" id="reply" class="form-control" rows="4" required>${review.reply!''}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit Reply</button>
        <a href="/reports" class="btn btn-secondary ms-2">Cancel</a>
    </form>
</body>
</html>
