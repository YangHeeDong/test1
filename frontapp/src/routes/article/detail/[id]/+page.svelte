<script>
	import { page } from '$app/stores';
	import { onMount } from 'svelte';
	import moment from 'moment/min/moment-with-locales';
	moment.locale('ko');

	import { browser } from '$app/environment';

	// let article:Article = [];
	let article = [];
	// 마운트 후에
	onMount(() => {
		// 페이지 매개변수로부터 id 추출
		const id = $page.params['id'];

		fetch('http://localhost:8080/api/v1/articles/' + id)
			.then((response) => response.json())
			.then((json) => (article = json.data.article));
	});
</script>

<div class="card border-dark mb-2">
	<div class="card-header text-white bg-dark">
		<span>No.{article.id}</span>
		<span class="float-end">작성자</span>
	</div>
	<div class="card-body text-dark">
		<h5 class="card-title">{article.title}</h5>
		<p class="card-text">{article.content}</p>
		<p class="badge bg-light text-dark float-end ">{moment(article.createDate).format('YYYY-MM-DD')}</p>
	</div>
</div>

<a class="btn btn-sm btn-primary text-decoration-none" href="/article/list">목록으로</a>