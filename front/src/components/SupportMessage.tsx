
import React from 'react';
import { Button } from '@/components/ui/button';

const SupportMessage = () => {
  return (
    <section id="wsparcie" className="w-full py-16 px-4 md:px-10 bg-gradient-to-br from-blue-50 to-green-50">
      <div className="max-w-5xl mx-auto grid grid-cols-1 lg:grid-cols-2 gap-12 items-center">
        <div>
          <h2 className="text-3xl font-bold mb-6">Razem pokonamy alkoholizm</h2>
          <p className="text-gray-700 mb-6">
            Alkoholizm to choroba, która dotyka miliony ludzi na całym świecie. Nie musisz walczyć sam. Nasza aplikacja pomaga monitorować Twoje postępy, łączy z grupami wsparcia i pokazuje, jak wiele osób przechodzi przez podobne trudności.
          </p>
          <p className="text-gray-700 mb-6">
            Pamiętaj, każdy dzień bez alkoholu to zwycięstwo. Małe kroki prowadzą do wielkich zmian.
          </p>
          <div className="flex flex-wrap gap-4">
            <Button className="bg-secondary hover:bg-secondary/90">Dołącz do społeczności</Button>
            <Button variant="outline">Znajdź pomoc w pobliżu</Button>
          </div>
        </div>
        <div className="bg-white p-6 rounded-xl shadow-lg">
          <h3 className="text-xl font-bold mb-4 text-center">Korzyści z życia bez alkoholu:</h3>
          <ul className="space-y-4">
            {[
              'Lepsze zdrowie fizyczne i psychiczne',
              'Poprawa relacji z bliskimi',
              'Więcej energii i lepsza jakość snu',
              'Oszczędność pieniędzy i czasu',
              'Pełna kontrola nad swoim życiem'
            ].map((benefit, index) => (
              <li key={index} className="flex items-start">
                <div className="flex-shrink-0 w-5 h-5 rounded-full bg-green-500 flex items-center justify-center mt-1 mr-3">
                  <svg className="h-3 w-3 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={3} d="M5 13l4 4L19 7" />
                  </svg>
                </div>
                <span>{benefit}</span>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </section>
  );
};

export default SupportMessage;
