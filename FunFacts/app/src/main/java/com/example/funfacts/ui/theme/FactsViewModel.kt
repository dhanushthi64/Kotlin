package com.example.funfacts.ui.theme

import androidx.lifecycle.ViewModel

class FactsViewModel: ViewModel() {
    fun generateRandomFacts(selected: String):String{
        if (selected == "Dog"){
            return getDogFacts().random()
        }
        else{
            return getCatFacts().random()
        }
    }
    fun getDogFacts() : List<String>{
        val dogFacts = listOf(
            "Dog noses are super sniffers - 40x better than ours!",
            "Some dogs are medical whizzes, sniffing out diseases.",
            "They can breathe and smell at the same time - handy for multitasking.",
            "Not all heroes wear capes - some are Newfoundlands, amazing lifeguards.",
            "Greyhounds are speedy - they could outrun a cheetah in a long race!",
            "Don't be fooled by the floppy ears - dogs have super hearing.",
            "Wagging their tails isn't just happy dances - it communicates too.",
            "Paw preference! Just like humans, some dogs are righties, some lefties.",
            "Dreaming doggos! They experience REM sleep, just like us.",
            "Playful pups? There's a reason - play helps them learn social skills.",
        )
        return dogFacts
    }

    fun getCatFacts(): List<String>{
        val catFcats = listOf(
            "Ninja jumps! Cats can leap up to 5 times their height.",
            "Speedy cheetahs? Nope, cats are faster in short bursts.",
            "Purrfect night vision: Cats see way better in the dark than us.",
            "Secret weapon: Their rough tongue grooms and shreds meat perfectly.",
            "Taste bud trick: Cats can't taste sweetness, just salty, sour, bitter, and savory.",
            "Ear yoga: Cats can swivel their ears 180 degrees!",
            "Chatty with humans: Cats mostly meow to communicate with us.",
            "Sleepyheads: Cats spend most of their lives napping (around 16 hours a day).",
            "Scentsational friends: Cats rub on you to mark you as their own.",
            "Unique ID: Every cat's nose print is like a fingerprint."
        )
        return catFcats
    }
}