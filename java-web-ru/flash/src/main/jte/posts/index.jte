@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="container">
        <h1>Posts</h1>
        @if(page.getFlash() != null)
            <div class="alert alert-success" role="alert">
                ${page.getFlash()}
            </div>
        @endif
        <ul class="list-group">
            @for(Post post : page.getPosts())
                <li class="list-group-item">
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </li>
            @endfor
        </ul>
    </div>
`
)
