import React, { FormEvent, useState } from 'react';
import BlogService from '../../service/BlogService';
import { useNavigate } from 'react-router-dom';

export default function AddBlog() {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const navigate = useNavigate();

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const blogService = new BlogService();
    const res = await blogService.addBlog(title, content);
    if (res.status === 201) navigate(0);
  }
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input
          type='text'
          name='title'
          id='title'
          placeholder='title'
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <input
          type='text'
          name='content'
          id='content'
          placeholder='content'
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
        <button type='submit'>POST</button>
      </form>
    </div>
  );
}
