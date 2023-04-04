import React, { useState } from 'react';
import CommentService from '../../service/CommentService';
import { useNavigate } from 'react-router-dom';
import { useAuthContext } from '../../context/AuthContext';

export default function PostComment({ blogid }: { blogid: string }) {
  const [comment, setComment] = useState('');
  const { authToken } = useAuthContext();
  const navigate = useNavigate();
  async function handleSubmit(e: any) {
    e.preventDefault();
    const commentService = new CommentService();
    const res = await commentService.addCommentToBlog(blogid, comment);
    if (res.status === 201) navigate(0);
  }

  if (authToken)
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
  else return <span>Please Login to comment</span>;
}
