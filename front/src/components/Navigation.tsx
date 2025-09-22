
import React from 'react';
import { Button } from '@/components/ui/button';
import { Heart } from 'lucide-react';

const Navigation = () => {
  return (
    <nav className="w-full py-5 px-4 md:px-10 flex justify-between items-center">
      <div className="flex items-center gap-2">
        {/* <Heart className="h-6 w-6 text-primary" /> */}
        <img src="/img/mam_kaca_icon.png" alt="MamKaca.pl Logo" className="h-8 w-8" />
        <h1 className="text-xl font-bold">MamKaca.pl</h1>
      </div>
      <div className="hidden md:flex gap-6 items-center">
        <a href="#statystyki" className="text-sm font-medium hover:text-primary transition-colors">
          Statystyki
        </a>
        <a href="#wsparcie" className="text-sm font-medium hover:text-primary transition-colors">
          Wsparcie
        </a>
        <a href="#aplikacja" className="text-sm font-medium hover:text-primary transition-colors">
          Aplikacja
        </a>
        <Button className="rounded-full" variant="outline">
          Potrzebuję pomocy
        </Button>
      </div>
      <Button className="md:hidden" variant="ghost">
        <svg className="h-6 w-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
        </svg>
      </Button>
    </nav>
  );
};

export default Navigation;
