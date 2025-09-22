
import React from 'react';
import { Heart } from 'lucide-react';
import BuyMeACoffeeButton from './BuyMeCoffee';


const Footer = () => {
  return (
    <footer className="w-full py-12 px-4 md:px-10 bg-gray-50">
      <div className="max-w-6xl mx-auto">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8 mb-12">
          <div>
            <div className="flex items-center gap-2 mb-4">
            <img src="/img/mam_kaca_icon.png" alt="MamKaca.pl Logo" className="h-8 w-8" />
              <h3 className="text-xl font-bold">MamKaca.pl</h3>
            </div>
            <p className="text-gray-600">
              Nasza misja to wsparcie osób walczących z uzależnieniem od alkoholu, promowanie trzeźwego stylu życia i budowanie społeczności wzajemnego wsparcia.
            </p>
          </div>
          <div>
            <h4 className="text-lg font-bold mb-4">Szybki dostęp</h4>
            <ul className="space-y-3">
              <li><a href="#" className="text-gray-600 hover:text-primary transition-colors">Strona główna</a></li>
              <li><a href="#statystyki" className="text-gray-600 hover:text-primary transition-colors">Statystyki</a></li>
              <li><a href="#wsparcie" className="text-gray-600 hover:text-primary transition-colors">Wsparcie</a></li>
              <li><a href="#aplikacja" className="text-gray-600 hover:text-primary transition-colors">Pobierz aplikację</a></li>
            </ul>
          </div>
          <div>
            <h4 className="text-lg font-bold mb-4">Wsparcie</h4>
            <ul className="space-y-3">
              <li><a href="#" className="text-gray-600 hover:text-primary transition-colors">Znajdź pomoc</a></li>
              <li><a href="#" className="text-gray-600 hover:text-primary transition-colors">Grupy wsparcia</a></li>
              <li><a href="#" className="text-gray-600 hover:text-primary transition-colors">Blog</a></li>
              <li><a href="#" className="text-gray-600 hover:text-primary transition-colors">Kontakt</a></li>
            </ul>
          </div>
        </div>
        <div className="border-t border-gray-200 pt-6 flex flex-col md:flex-row justify-between items-center">
          <p className="text-sm text-gray-500">&copy; {new Date().getFullYear()} MamKaca.pl - Wszystkie prawa zastrzeżone</p>
          <div className="flex gap-6 mt-4 md:mt-0">
            <a href="#" className="text-gray-500 hover:text-primary transition-colors">
              Polityka prywatności
            </a>
            <a href="#" className="text-gray-500 hover:text-primary transition-colors">
              Warunki korzystania
            </a>
          </div>
        </div>


        <div className="flex flex-col md:flex-row justify-between items-center mt-6">
          <div className="flex items-center gap-2 text-sm text-gray-500">
            <Heart className="h-4 w-4 text-red-500" />
            <span>Jeśli podoba Ci się nasza praca, możesz nas wesprzeć:</span>
          </div>
          <BuyMeACoffeeButton
            username="abramovvicz"
            className="mt-4 md:mt-0"
          />
        </div>




      </div>
    </footer>
  );
};

export default Footer;
