import { requestHelper } from './http';

class CommentService {
    async addCommentToBlog(blogid: string, content: string) {
        const path = `comment`
        const body = {
            blogid,
            content
        }
        return await requestHelper('post', path, body)
    }
}


export default CommentService;