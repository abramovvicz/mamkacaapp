
import React from 'react';
import Navigation from '@/components/Navigation';
import HeroSection from '@/components/HeroSection';
import Statistics from '@/components/Statistics';
import SupportMessage from '@/components/SupportMessage';
import Footer from '@/components/Footer';

const Index = () => {
  return (
    <div className="min-h-screen flex flex-col">
      <Navigation />
      <HeroSection />
      <Statistics />
      <SupportMessage />
      <Footer />
    </div>
  );
};

export default Index;
