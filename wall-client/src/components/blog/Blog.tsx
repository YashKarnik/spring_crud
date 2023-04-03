import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import BlogService from '../../service/BlogService';
import Comment from '../comment/Comment';
import PostComment from '../comment/PostComment';
import UpdateBlog from './UpdateBlog';

export default function Blog() {
  const { blogid } = useParams();
  const [blog, setBlog] = useState<BlogType>();
  useEffect(() => {
    const blogService = new BlogService();
    blogService.getBlogByBlogId(Number(blogid)).then((res) => {
      setBlog(res.data);
    });
  }, [blogid]);

  async function deleteBlog() {
    const blogService = new BlogService();
    await blogService.deleteBlog(Number(blogid));
  }

  return (
    <div>
      {blogid}
      <h1>title- {blog?.title}</h1>
      <p>content- {blog?.content}</p>
      <p>date created- {blog?.dateCreated}</p>
      <p> writtenBy- {blog?.userid}</p>
      <button onClick={deleteBlog}>DELETE</button>
      <br />
      <br />
      <Link to={`./update`}>UPDATE BLOG</Link>
      <h2>--Comments--</h2>
      <PostComment blogid={blogid || ''} />
      {blog?.commentDetailsVO?.map((comment, i) => {
        return <Comment comment={comment} key={i} />;
      })}
    </div>
  );
}
