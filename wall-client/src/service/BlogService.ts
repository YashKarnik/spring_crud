import { requestHelper } from './http';


class BlogService {
    async getAlluserBlogs() {
        const path = `blog`
        return await requestHelper('get', path, null)
    }

    async getBlogByBlogId(blogid: Number) {
        const path = `blog/${blogid}`
        return await requestHelper('get', path, null)
    }
    async addBlog(title: string, content: string) {
        const path = `blog`
        const body = {
            title,
            content
        }
        return await requestHelper('post', path, body)

    }
    async updateBlog(blogid: string, title: string, content: string) {
        const path = `blog`
        const body = {
            blogid,
            title,
            content
        }
        return await requestHelper('put', path, body)
    }
    async deleteBlog(blogid: number) {
        const path = `blog/${blogid}`
        return await requestHelper('delete', path)

    }

}

export default BlogService