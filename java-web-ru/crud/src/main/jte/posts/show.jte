@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes

@param NamedRoutes path
@param PostPage page

@template.layout.page(
content = @`
    <a href="${path.postsPath()}">Posts</a>
    <div>
        <h2>${page.getPost().getName()}</h2>
        <p>${page.getPost().getBody()}</p>
    </div>
`
)