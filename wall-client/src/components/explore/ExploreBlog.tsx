import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import BlogService from '../../service/BlogService';
import Comment from '../comment/Comment';
import PostComment from '../comment/PostComment';

export default function ExploreBlog() {
  const { blogid } = useParams();

  const [blog, setBlog] = useState<BlogType>();
  useEffect(() => {
    const blogService = new BlogService();
    blogService.getPublicBlogByBlogId(Number(blogid)).then((res) => {
      setBlog(res.data);
    });
  }, [blogid]);

  return (
    <div>
      {blogid}
      <h1>title- {blog?.title}</h1>
      <p>content- {blog?.content}</p>
      <p>date created- {blog?.dateCreated}</p>
      {/* <p> writtenBy- {blog?.userid}</p> */}
      <br />
      <br />
      <h2>--Comments--</h2>
      <PostComment blogid={blogid || ''} />
      {blog?.commentDetailsVO?.map((comment, i) => {
        return <Comment comment={comment} key={i} />;
      })}
    </div>
  );
}
