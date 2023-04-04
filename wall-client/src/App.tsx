import React from 'react';
import Login from './components/Login/Login';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Register from './components/Register/Register';
import { AuthContextProvider, useAuthContext } from './context/AuthContext';
import Blogs from './components/blog/Blogs';
import Blog from './components/blog/Blog';
import UpdateBlog from './components/blog/UpdateBlog';
import ExploreBlogs from './components/explore/ExploreBlogs';
import ExploreBlog from './components/explore/ExploreBlog';
function App() {
  return (
    <AuthContextProvider>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<ExploreBlogs />} />
          <Route path='/login' element={<Login />} />
          <Route path='/register' element={<Register />} />
          <Route path='/blogs' element={<ProtectedRoute element={Blogs} />} />
          <Route
            path='/blogs/:blogid'
            element={<ProtectedRoute element={Blog} />}
          />
          <Route
            path='/blogs/:blogid/update'
            element={<ProtectedRoute element={UpdateBlog} />}
          />
          <Route path='/explore' element={<ExploreBlogs />} />
          <Route path='/explore/:blogid' element={<ExploreBlog />} />
        </Routes>
      </BrowserRouter>
    </AuthContextProvider>
  );
}

export default App;

function ProtectedRoute({ element: Element }: { element: React.ElementType }) {
  const { authToken } = useAuthContext();
  if (authToken)
    return (
      <React.Fragment>
        <Element />
      </React.Fragment>
    );
  // else <Navigate to='/login' />;
  else
    return (
      <React.Fragment>
        <Navigate to='/login' />
      </React.Fragment>
    );
}
