import React, { useEffect, useState } from 'react';
import BlogService from '../../service/BlogService';
import AddBlog from './AddBlog';
import { Link } from 'react-router-dom';
function Blogs() {
  const [blogs, setBlogs] = useState<BlogType[]>();
  useEffect(() => {
    const blogService = new BlogService();
    blogService.getAlluserBlogs().then((res) => {
      setBlogs(res.data);
    });
  }, []);

  return (
    <div>
      blogs--
      <AddBlog />
      {blogs?.map((e, i) => {
        return <Blog key={i} blog={e} />;
      })}
    </div>
  );
}
function Blog({ blog }: { blog: BlogType }) {
  return (
    <div>
      <h1>
        <Link to={`./${blog.blogid}`}>{blog.title}</Link>
      </h1>
      <p>{blog.content}</p>
      <p>{blog.dateCreated}</p>
      <p>{blog.userid}</p>
    </div>
  );
}

export default Blogs;
