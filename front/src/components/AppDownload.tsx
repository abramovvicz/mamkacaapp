
import React from 'react';
import { Button } from '@/components/ui/button';

const AppDownload = () => {
  return (
    <>
      <a href="https://play.google.com/store" target="_blank" rel="noopener noreferrer" id="aplikacja" className="app-button app-button-android">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="mr-2">
          <path d="M5 12V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2v-5" />
          <path d="M14 9H5a2 2 0 0 0-2 2v0a2 2 0 0 0 2 2h9" />
          <path d="m13 5 3 4.5L13 14" />
        </svg>
        Android
      </a>
      <a href="https://apps.apple.com/" target="_blank" rel="noopener noreferrer" className="app-button app-button-ios">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="mr-2">
          <path d="M12 20.94c1.5 0 2.75 1.06 4 1.06 3 0 6-8 6-12.22A4.91 4.91 0 0 0 17 5c-2.22 0-4 1.44-5 2-1-.56-2.78-2-5-2a4.9 4.9 0 0 0-5 4.78C2 14 5 22 8 22c1.25 0 2.5-1.06 4-1.06Z" />
          <path d="M12 7c3.3 0 4-2 4-2-3.3 0-4 2-4 2Z" />
        </svg>
        iOS
      </a>
    </>
  );
};

export default AppDownload;
