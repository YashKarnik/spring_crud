import React, { FormEvent, useEffect, useState } from 'react';
import BlogService from '../../service/BlogService';
import { useParams, useNavigate } from 'react-router-dom';

export default function UpdateBlog() {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const { blogid } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const blogService = new BlogService();
    blogService.getBlogByBlogId(Number(blogid)).then((res) => {
      setTitle(res.data.title);
      setContent(res.data.content);
    });
  }, [blogid]);

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const blogService = new BlogService();
    const res = await blogService.updateBlog(blogid || '', title, content);
    if (res.status === 200) navigate(-1);
  }
  return (
    <div>
      <h1>UPDATE blog with id {blogid}</h1>
      <form onSubmit={handleSubmit}>
        <input
          type='text'
          name='title'
          id='title'
          placeholder='title'
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <br />
        <br />
        <textarea
          name='content'
          id='content'
          rows={10}
          cols={100}
          placeholder='content'
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
        <br />
        <button type='submit'>POST</button>
      </form>
    </div>
  );
}
