
import React from 'react';
import { useQuery } from '@tanstack/react-query';
import { Card, CardContent } from '@/components/ui/card';

interface CounterCardProps {
  title: string;
  description: string;
  icon: React.ReactNode;
  apiEndpoint: string;
}

const fetchCount = async (endpoint: string) => {
  const response = await fetch(endpoint);
  if (!response.ok) {
    throw new Error('Failed to fetch data');
  }
  const data = await response.json()
  console.log('=== DANE Z API ===');
  console.log('Raw data:', data);
  console.log('Klucze obiektu:', Object.keys(data));
  console.log('Liczba kluczy:', Object.keys(data).length);
  console.log('Stringified:', JSON.stringify(data, null, 2));
  console.log('Wyciaganie z daty klucza: i endoint jest ?',endpoint, JSON.stringify(data.totalVotes));
  return data
};

const CounterCard = ({ title, description, icon, apiEndpoint }: CounterCardProps) => {
  const { data, isLoading, error } = useQuery({
    queryKey: [apiEndpoint],
    queryFn: () => fetchCount(apiEndpoint)
  });

  return (
    <div className="counter-card">
      <div className="flex items-start">
        <div className="p-3 rounded-full bg-white/60 mr-4">
          {icon}
        </div>
        <div>
          <h3 className="text-sm font-medium text-gray-600">{title}</h3>
          <p className="text-3xl font-bold mt-1">
            {isLoading ? "..." : error ? "Error" : data?.totalVotes || "0"}
          </p>
          <p className="text-sm text-gray-600 mt-2">{description}</p>
        </div>
      </div>
    </div>
  );
};

export default CounterCard;