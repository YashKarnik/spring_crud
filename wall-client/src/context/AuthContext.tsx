import React, { useContext, createContext, useState } from 'react';

const AuthContext = createContext<any>(null);

export const useAuthContext = (): {
  authToken: string;
  setAuthToken: React.Dispatch<React.SetStateAction<string>>;
} => useContext(AuthContext);

export function AuthContextProvider(props: any) {
  const [authToken, setAuthToken] = useState('');
  return (
    <AuthContext.Provider value={{ authToken, setAuthToken }}>
      {props.children}
    </AuthContext.Provider>
  );
}
