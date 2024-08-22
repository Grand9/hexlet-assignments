@import exercise.dto.posts.PostsPage
@import exercise.model.Post
@import exercise.util.NamedRoutes

@param NamedRoutes path
@param PostsPage page

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <h1>No added posts yet.</h1>
    @else
        <div>
            @for(Post post : page.getPosts())
                <div>
                    <a href="${path.postPath(post.getId())}">${post.getName()}</a>
                </div>
            @endfor
        </div>
        @if(page.getPageNumber() == 1)
            <a href="${path.postsPath()}?page=${page.getPageNumber() + 1}">Next</a>
        @elseif(page.getPageNumber() == page.getLastPageNumber())
            <a href="${path.postsPath()}?page=${page.getPageNumber() - 1}">Back</a>
        @else
            <a href="${path.postsPath()}?page=${page.getPageNumber() - 1}">Back</a>
            <a href="${path.postsPath()}?page=${page.getPageNumber() + 1}">Next</a>
        @endif
    @endif
`
)