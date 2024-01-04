<script>
	import { browser } from '$app/environment';
	import { onMount } from 'svelte';
	onMount(() => {

		document.getElementById('submitArticleForm').onsubmit = function () {
			myFunction();
		};

		function myFunction() {
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            if(title.trim().length == 0){
                alert("title is required");
                return;
            }
            if(content.trim().length == 0){
                alert("content is required");
                return;
            }
            fetch('http://localhost:8080/api/v1/articles', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    title: title,
                    content: content
                })
            })
            .then(response => response.json())
            .then(rs => {
                alert(rs.msg);
                window.location.href = "/article/detail/"+rs.data.article.id;
            })
            .catch(error => {
                console.error(error);
            });
		}
	});
</script>

<h3>Create Article</h3>
<form id="submitArticleForm">
	<div class="input-group">
		<span class="input-group-text bg-dark text-white border-dark">Title</span>
		<input
            id = "title"
			type="text"
			name="title"
			class="form-control border-dark"
			placeholder="Enter title"
			aria-describedby="basic-addon1"
		/>
	</div>

	<div class="input-group mt-1">
		<span class="input-group-text bg-dark text-white border-dark">body</span>
		<textarea
            id = "content"
			name="content"
			class="form-control border-dark"
			aria-label="With textarea"
			rows="20"
			placeholder="Enter body"
		></textarea>
	</div>

	<div class="mt-2">
		<a class=" btn btn-sm btn-primary text-decoration-none" href="/article/list">목록으로</a>
		<button type="submit" class="btn btn-sm bg-dark text-white text-decoration-none float-end">등록</button>
	</div>
</form>
