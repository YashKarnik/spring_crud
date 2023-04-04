import React, { useEffect, useState } from 'react';
import BlogService from '../../service/BlogService';
import { Link, useSearchParams } from 'react-router-dom';

function ExploreBlogs() {
  const [blogs, setBlogs] = useState<BlogType[]>();
  const [count, setCount] = useState(-1);
  const [searchParams] = useSearchParams();
  const limit = searchParams.get('limit');
  const pageNumber = searchParams.get('page_number');
  useEffect(() => {
    const blogService = new BlogService();
    blogService.getPublicBlogsCount().then((res) => setCount(res.data));
    blogService
      .getPublicBlogs(Number(limit) || 10, Number(pageNumber) || 10)
      .then((res) => setBlogs(res.data));
  }, [limit, pageNumber]);

  return (
    <div>
      total count {count}
      {blogs?.map((blog) => {
        return <Blog blog={blog} />;
      })}
    </div>
  );
}
export default ExploreBlogs;

function Blog({ blog }: { blog: BlogType }) {
  return (
    <div>
      <h1>
        <Link to={`./explore/${blog.blogid}`}>{blog.title}</Link>
      </h1>
      <p>{blog.content}</p>
      <p>{blog.dateCreated}</p>
    </div>
  );
}
