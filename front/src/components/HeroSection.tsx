
import React from 'react';
import AppDownload from './AppDownload';

const HeroSection = () => {
  return (
    <section className="w-full min-h-[70vh] gradient-bg flex flex-col md:flex-row items-center justify-between py-12 px-4 md:px-10 gap-8">
      <div className="flex-1 max-w-xl ml-[20%]">
        <h1 className="text-4xl md:text-5xl font-bold mb-4 leading-tight">
          Pokonaj kaca i <span className="text-primary">uwolnij</span> się od alkoholu
        </h1>
        <p className="text-lg text-gray-700 mb-8">
          MamKaca pomaga w walce z alkoholizmem poprzez monitorowanie trzeźwości, łączenie ze wsparciem i pokazywanie realnych postępów w drodze do zdrowszego życia.
        </p>
        <div className="flex flex-col sm:flex-row gap-4">
          <AppDownload />
        </div>
      </div>
      <div className="flex-1 flex justify-center relative animate-float">
        <div className="w-64 h-[500px] bg-white rounded-3xl shadow-xl border border-gray-100 overflow-hidden">
          <div className="w-full h-8 bg-gray-100 flex items-center justify-center">
            <div className="w-16 h-4 bg-gray-200 rounded-full"></div>
          </div>
          <div className="p-4 bg-blue-50 h-48">
            <div className="mb-4 flex items-center gap-2">
              <div className="w-8 h-8 rounded-full bg-blue-500"></div>
              <div className="text-sm font-medium">Dzień 30 bez alkoholu</div>
            </div>
            <div className="w-full bg-white rounded-lg p-3 shadow-sm">
              <div className="text-xs text-gray-500">Twój postęp</div>
              <div className="w-full h-3 bg-gray-200 rounded-full mt-2">
                <div className="w-3/4 h-full bg-green-500 rounded-full"></div>
              </div>
              <div className="mt-2 text-right text-xs font-medium">75%</div>
            </div>
          </div>
          <div className="p-4">
            <div className="w-full h-12 bg-gray-100 rounded-lg mb-4"></div>
            <div className="w-full h-12 bg-gray-100 rounded-lg mb-4"></div>
            <div className="w-3/4 h-12 bg-gray-100 rounded-lg"></div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default HeroSection;