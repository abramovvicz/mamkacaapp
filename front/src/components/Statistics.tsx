
import React from 'react';
import CounterCard from './CounterCard';
import { Calendar, Users, ChartBarIcon } from 'lucide-react';

const Statistics = () => {
  return (
    <section id="statystyki" className="w-full py-20 px-4 md:px-10">
      <div className="text-center mb-12">
        <h2 className="text-3xl font-bold mb-4">Statystyki kaca w Polsce</h2>
        <p className="text-gray-600 max-w-2xl mx-auto">
          Monitoring w czasie rzeczywistym pokazuje, ile osób zmaga się z kacem dzisiaj i w tym miesiącu. Dołącz do nas i pomóż zmniejszyć te liczby.
        </p>
      </div>
      
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 max-w-5xl mx-auto">
        <CounterCard
          title="Dzisiaj"
          description="osób zgłosiło kaca"
          icon={<Calendar className="h-6 w-6 text-primary" />}
          apiEndpoint="https://3.71.255.220:8080/api/stats/today"
        />
        
        <CounterCard
          title="W tym miesiącu"
          description="przypadków kaca"
          icon={<ChartBarIcon className="h-6 w-6 text-primary" />}
          apiEndpoint="https://3.71.255.220:8080/api/stats/month"
        />
        
        <CounterCard
          title="Aktywni użytkownicy"
          description="osób walczy z nałogiem"
          icon={<Users className="h-6 w-6 text-primary" />}
          apiEndpoint="https://3.71.255.220:8080/api/stats/year"
        />
      </div>
    </section>
  );
};

export default Statistics;