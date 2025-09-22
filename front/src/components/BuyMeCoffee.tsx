// BuyMeACoffeeButton.tsx
import React, { useEffect } from 'react';

interface BuyMeACoffeeButtonProps {
  username: string;
  className?: string;
}

const BuyMeACoffeeButton: React.FC<BuyMeACoffeeButtonProps> = ({ 
  username, 
  className = "" 
}) => {
  useEffect(() => {
    if (document.querySelector('script[data-name="bmc-button"]')) {
      return;
    }

    const script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'https://cdnjs.buymeacoffee.com/1.0.0/button.prod.min.js';
    script.setAttribute('data-name', 'bmc-button');
    script.setAttribute('data-slug', username);
    script.setAttribute('data-color', '#FFDD00');
    script.setAttribute('data-emoji', '☕');
    script.setAttribute('data-font', 'Cookie');
    script.setAttribute('data-text', 'Buy me a coffee');
    script.setAttribute('data-outline-color', '#000000');
    script.setAttribute('data-font-color', '#000000');
    script.setAttribute('data-coffee-color', '#ffffff');
    
    document.body.appendChild(script);

    return () => {
      const existingScript = document.querySelector('script[data-name="bmc-button"]');
      if (existingScript) {
        existingScript.remove();
      }
    };
  }, [username]);

  return <div className={className} id="bmc-button-container"></div>;
};

export default BuyMeACoffeeButton;