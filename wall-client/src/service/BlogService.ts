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

    async getPublicBlogs(limit: number = 10, pageNumber: number = 10) {
        const path = `blog/explore?limit=${limit}&pageNumber=${pageNumber}`
        return await requestHelper('get', path)
    }

    async getPublicBlogByBlogId(blogid: number) {
        const path = `blog/explore/${blogid}`
        return await requestHelper('get', path)
    }

    async getPublicBlogsCount() {
        const path = `blog/count`
        return await requestHelper('get', path)
    }
}

export default BlogService