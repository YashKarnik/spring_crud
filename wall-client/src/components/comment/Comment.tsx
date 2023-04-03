import React from 'react';

export default function Comment({ comment }: { comment: CommentType }) {
  return (
    <div>
      <hr />
      <h4>{comment.username}</h4>
      <h5>{comment.content}</h5>
    </div>
  );
}
