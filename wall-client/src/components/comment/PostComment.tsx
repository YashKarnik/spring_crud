import React, { useState } from 'react';
import CommentService from '../../service/CommentService';
import { useNavigate } from 'react-router-dom';

export default function PostComment({ blogid }: { blogid: string }) {
  const [comment, setComment] = useState('');
  const navigate = useNavigate();
  async function handleSubmit(e: any) {
    e.preventDefault();
    console.log(comment);
    const commentService = new CommentService();
    const res = await commentService.addCommentToBlog(blogid, comment);
    if (res.status === 201) navigate(0);
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input
          value={comment}
          onChange={(e) => setComment(e.target.value)}
          type='text'
          name='comment'
          id='comment'
          placeholder='Type comment here'
        />
        <button type='submit'>POST COMMENT</button>
      </form>
    </div>
  );
}
